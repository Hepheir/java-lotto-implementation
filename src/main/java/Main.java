import domain.*;
import domain.LottoBuyingOption;
import domain.LottoGradingOptions;
import io.Console;
import controllers.ConsoleController;
import controllers.Controller;
import io.SampleConsole;
import languages.Korean;
import views.ConsoleView;
import views.View;

public class Main {
    public static void main(String[] args) {
//        Console console = new Console();
        Console console = new SampleConsole();

        View view = ConsoleView.builder()
                .console(console)
                .language(new Korean())
                .build();

        Controller controller = ConsoleController.builder()
                .console(console)
                .view(view)
                .build();

        LottoBuyingOption buyingOption = controller.getLottoBuyingOption();
        LottoTicketSequence boughtTickets = controller.getBoughtTickets(buyingOption);
        LottoGradingOptions gradingOptions = controller.getLottoGradingOptions();
        LottoWinningStatSequence winningStats = controller.getLottoWinningStats(gradingOptions, boughtTickets);
        Double profitRate = controller.getProfitRate(buyingOption, winningStats);
    }
}
