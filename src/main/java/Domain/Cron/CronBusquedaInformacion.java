package Domain.Cron;

import Domain.Equipo.*;
import Domain.Repositories.RepositorioDeEquipos;
import Domain.Repositories.Factories.FactoryRepositorioEquipos;
import Domain.ServicioInformacion.ServicioApi;
import Domain.ServicioInformacion.ServicioEquipo;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CronBusquedaInformacion implements Job {
  private static int count = 0;

  private RepositorioDeEquipos repoEquipos = FactoryRepositorioEquipos.get();
  private ServicioApi servicio;


  @Override
  public void execute(JobExecutionContext jobContext) throws JobExecutionException {

    JobDetail jobDetail = jobContext.getJobDetail();
    count++;

    Logger.getInstance().loggearCron("--------------------------------------------------------------------");
    Logger.getInstance().loggearCron("EJECUTANDO JOB " + jobDetail.getKey());
    Logger.getInstance().loggearCron("Ejecucion Num. " + count);
    Logger.getInstance().loggearCron("Inicio: " + jobContext.getFireTime());
    Logger.getInstance().loggearCron("Info: " + jobDetail.getJobDataMap().getString("ejemplo"));
    Logger.getInstance().loggearCron("Fin: " + jobContext.getJobRunTime());
    Logger.getInstance().loggearCron("Proxima ejecucion: " + jobContext.getNextFireTime());
    Logger.getInstance().loggearCron("--------------------------------------------------------------------");

    //Busqueda de informacion
    
      ServicioEquipo servicioEquipo = new ServicioEquipo(servicio.getApiKey());
      servicio.setServicioBusquedaInformacion(servicioEquipo);

    for (Equipo equipo : this.repoEquipos.buscarTodos()) {

      String estado;
      EstadoVerde estadoVerde = new EstadoVerde(equipo);
      EstadoAmarillo estadoAmarillo = new EstadoAmarillo(equipo);
      EstadoRojo estadoRojo = new EstadoRojo(equipo);

      try {

      estado = ((ServicioEquipo) servicio.getServicioBusquedaInformacion()).buscarInfoEquipo(equipo.getNombre());


      switch(estado){
        case "Verde":
          equipo.setEstado(estadoVerde);
          break;

        case "Amarillo":
          equipo.setEstado(estadoAmarillo);
          break;

        case "Rojo":
          equipo.setEstado(estadoRojo);
          break;

      }

      equipo.getEstado().modificarEntrenamiento();
      equipo.notificarObservers();

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }


    //aca uso el jobdatamap con mis objetos de negocio
    CountDownLatch contadorSincronico = (CountDownLatch) jobDetail.getJobDataMap().get("contadorSincronico");
    contadorSincronico.countDown();
    if (count == 2) {
      throw new RuntimeException("RuntimeException!");
    }
    if (count == 4) {
      throw new JobExecutionException("JobExecutionException!");
    }

  }
}
