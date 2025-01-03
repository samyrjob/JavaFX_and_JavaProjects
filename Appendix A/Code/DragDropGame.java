import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DragDropGame extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        // Create a draggable item
        Text item = new Text("Drag me!");
        item.setX(50);
        item.setY(50);
        
        // Create a bin (target area)
        Rectangle bin = new Rectangle(100, 100, 100, 100);
        bin.setFill(Color.LIGHTGRAY);
        bin.setX(200);
        bin.setY(100);

        // Enable drag event
        item.setOnDragDetected(event -> {
            item.startFullDrag();
            event.consume();
        });

        // Enable drop event
        bin.setOnMouseDragReleased(event -> {
            if (event.getGestureSource() == item) {
                item.setX(bin.getX() + 20);
                item.setY(bin.getY() + 20);
            }
            event.consume();
        });

        pane.getChildren().addAll(item, bin);
        Scene scene = new Scene(pane, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Drag and Drop Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
