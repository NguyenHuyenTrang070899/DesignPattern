public class Factory { //Client
    public static void main(String[] args) {
        Tool tool = ToolFactory.getTool(ToolType.PEN);
        System.out.println(tool.getToolName());
    }
}
interface Tool { //Superclass
    String getToolName();
}
class Pen implements Tool { //Subclass1
    public String getToolName() {
        return "PEN";
    }
}
class Notebook implements Tool { //Subclass2
    public String getToolName() {
        return "NOTEBOOK";
    }
}
enum ToolType {
    PEN, NOTEBOOK;
}
class ToolFactory {
    private ToolFactory() {} //Singleton
    public static final Tool getTool(ToolType toolType) {
        switch(toolType) {
            case PEN:
                return new Pen();
            case NOTEBOOK:
                return new Notebook();
            default:
                throw new UnsupportedOperationException("This furniture is unsupported ");
        }
    }
}
