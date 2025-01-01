module org.nullhater.circlebattlefield {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires ch.qos.logback.core;
    requires ch.qos.logback.classic;
    requires static lombok;


    opens org.nullhater.circlebattlefield to javafx.fxml;
    exports org.nullhater.circlebattlefield;
}