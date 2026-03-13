import service.BancoService;

public class AppBanco {
    public static void main(String[] args) {

        BancoService bancoService = new BancoService();
        bancoService.menuInicial();
        bancoService.menuPrincipal();
    }
}