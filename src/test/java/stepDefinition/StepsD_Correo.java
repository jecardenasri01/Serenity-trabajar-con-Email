package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import serenity.Task_EnviarCorreo;
import serenity.Task_LeerCorreo;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepsD_Correo {


    @Given("^iniciar test")
    public void iniciartest() {

        OnStage.setTheStage(new OnlineCast());
        theActorCalled("TEAM QC");

    }
    @When("^lectura correo (.*) y (.*)")
    public void lecturacorreoy(String correo ,String clave){
        theActorInTheSpotlight().attemptsTo(Task_LeerCorreo.withRobotUser(correo,clave));
    }

    @When("^enviar correo (.*) , (.*) , (.*) y (.*)")
    public void enviarcorreo(String correo ,String clave,String asunto,String cuerpocorreo){
        theActorInTheSpotlight().attemptsTo(Task_EnviarCorreo.withRobotUser(correo,clave,asunto,cuerpocorreo));
    }
}
