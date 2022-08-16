package Domain.Cron;

import Domain.Equipo.*;
import Domain.Repositories.RepositorioDeEquipos;
import Domain.Repositories.Factories.FactoryRepositorioEquipos;
import Domain.ServicioInformacion.ServicioEquipo;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.concurrent.CountDownLatch;

public class CronBusquedaInformacion implements Job {
  private static int count = 0;

  private RepositorioDeEquipos repoEquipos = FactoryRepositorioEquipos.get();
  private ServicioEquipo servicioEquipo;

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
    
    EstadoVerde estadoVerde = new EstadoVerde();
    EstadoAmarillo estadoAmarillo = new EstadoAmarillo();
    EstadoRojo estadoRojo = new EstadoRojo();

    for (Equipo equipo : this.repoEquipos.buscarTodos()) {
      String estado = servicioEquipo.buscarInfoEquipo(equipo.getNombre());

      switch(estado){
        case "Verde":
          equipo.setEstado();
          break;

        case "Amarillo":
          equipo.setEstado(new EstadoAm);
          break;

        case "Rojo":
          equipo.setEstado(new EstadoAm);
          break;

      }

      equipo.getEstado().modificarEntrenamiento();
      equipo.notificarObservers();
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
