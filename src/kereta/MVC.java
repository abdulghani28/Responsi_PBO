package kereta;

public class MVC {
    KeretaModel keretaModel = new KeretaModel();
    KeretaView keretaView = new KeretaView();
    KeretaController keretaController = new KeretaController(keretaModel, keretaView);
}
