# Java command pattern example
There are four roles in command pattern client, invoker, receiver and command. `Command` invokes a method of `Receiver`
to finish one command. `Invoker` knows which command will be executed. `Invoker` and `Receiver` do not know each other.
After packaging the command you can repeat or undo it. 

The structure of command pattern is like following.

![Command Pattern](https://uploads.disquscdn.com/images/4917bdfcb82e77f081c924e2ce49a00180b3ebc3aa7250226146690a3fb0313f.png)

Command interface and concrete commands
```java
public interface Command {
    void execute();

    void undo();
}

public class CutCommand implements Command {
    private Document document;

    public CutCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.cut();
    }

    @Override
    public void undo() {
        document.undoCut();
    }
}

public class PasteCommand implements Command {
    private Document document;

    public PasteCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.paste();
    }

    @Override
    public void undo() {
        document.undoPaste();
    }
}
```
The implements of cut and paste operation are in `Document` (receiver).
```java
public class Document {
    public void paste(){
        System.out.println("paste word into document");
    }

    public void undoPaste(){
        System.out.println("undo paste word into document");
    }

    public void cut(){
        System.out.println("cut word from document");
    }

    public void undoCut(){
        System.out.println("undo cut word from document");
    }
}
```
Invoker (`MenuItem`) will invoke different commands and record them.
```java
public class MenuItem {
    private List<Command> history = new ArrayList<>();

    public void storeAndExecute(Command command) {
        history.add(command);
        command.execute();
    }

    public void undo() {
        for (int i = history.size() - 1; i >= 0; i--) {
            history.get(i).undo();
        }
    }
}
```
The code of client is like following.
```java
public class Client {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem();
        Document document = new Document();
        CutCommand cutCommand = new CutCommand(document);
        PasteCommand pasteCommand = new PasteCommand(document);
        menuItem.storeAndExecute(cutCommand);
        menuItem.storeAndExecute(pasteCommand);
        menuItem.undo();
    }
}
```
