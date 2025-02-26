package Commands;

public class Quit extends Command {
    @Override
    public String getLabel() {
        return "Quit";
    }

    @Override
    public void execute() {
        System.out.println("Goodbye !");
        System.exit(0);
    }
}