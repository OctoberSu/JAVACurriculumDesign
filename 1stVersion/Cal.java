import java.awt.datatransfer.StringSelection;
import java.math.BigDecimal;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.*;

import java.lang.String;
import java.io.*;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Clipboard;

import java.awt.datatransfer.StringSelection;

public class Cal extends Application {
    String ss = "";
    Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();
    boolean x2 = false;

    boolean res = false;

    String exp = "";

    @Override//重写主页面调用函数
    public void start(Stage primaryStage) {

        //主页面属性设置  主界面是一个垂直框架
        VBox mainPane = new VBox(10);
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        mainPane.prefHeightProperty().bind(primaryStage.heightProperty());
        mainPane.prefWidthProperty().bind(primaryStage.widthProperty());
        mainPane.setStyle("-fx-background-color: #000000;");


        //增加精度函数
        Button imp = new Button("improve");
        imp.prefWidthProperty().bind(mainPane.widthProperty().divide(2));
        imp.prefHeightProperty().bind(mainPane.heightProperty().divide(15));
        imp.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        imp.styleProperty().bind(
                Bindings
                        .when(imp.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));


        //四舍五入函数
        Button approx = new Button("approximate");
        approx.prefWidthProperty().bind(mainPane.widthProperty().divide(2));
        approx.prefHeightProperty().bind(mainPane.heightProperty().divide(15));
        approx.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        approx.styleProperty().bind(
                Bindings
                        .when(approx.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //一个水平框  用来存放增加精度按钮 与 四舍五入按钮
        HBox hb = new HBox(10);
        hb.getChildren().addAll(imp, approx);


        //计算器输入框
        TextField textField = new TextField();
        textField.prefHeightProperty().bind(mainPane.heightProperty().divide(3));
        textField.setStyle("-fx-font-size:29px;");
        textField.setAlignment(Pos.BOTTOM_RIGHT);


        //数字按钮 '9'
        Button num9 = new Button("9");
        num9.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num9.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num9.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num9.styleProperty().bind(
                Bindings
                        .when(num9.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //数字按钮'8'
        Button num8 = new Button("8");
        num8.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num8.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num8.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num8.styleProperty().bind(
                Bindings
                        .when(num8.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));


        //数字按钮'7'
        Button num7 = new Button("7");
        num7.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num7.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num7.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num7.styleProperty().bind(
                Bindings
                        .when(num7.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //运算符 '／'  用于除法运算
        Button div = new Button("/");
        div.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        div.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        div.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        div.styleProperty().bind(
                Bindings
                        .when(div.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #434343;")
                        ));

        //数字按钮'6'
        Button num6 = new Button("6");
        num6.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num6.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num6.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num6.styleProperty().bind(
                Bindings
                        .when(num6.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));


        //数字按钮'5'
        Button num5 = new Button("5");
        num5.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num5.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num5.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num5.styleProperty().bind(
                Bindings
                        .when(num5.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //数字按钮'4'
        Button num4 = new Button("4");
        num4.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num4.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num4.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num4.styleProperty().bind(
                Bindings
                        .when(num4.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));


        //运算符'*'   用于乘法运算
        Button mul = new Button("*");
        mul.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        mul.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        mul.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.REGULAR, 12));
        mul.styleProperty().bind(
                Bindings
                        .when(mul.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #949494;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #2e2e2e;")
                        ));

        //运算符'（'  左括号
        Button b1 = new Button("(");
        b1.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        b1.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        b1.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        b1.styleProperty().bind(
                Bindings
                        .when(b1.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        ));

        //运算符'）'  右括号
        Button b2 = new Button(")");
        b2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        b2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        b2.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        b2.styleProperty().bind(
                Bindings
                        .when(b2.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        ));


        //删除编辑键  '<-'  用于删除上一次输入的数字或者运算符
        Button backSpace = new Button("\u2190");
        backSpace.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        backSpace.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        backSpace.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        backSpace.styleProperty().bind(
                Bindings
                        .when(backSpace.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        ));

        //归零键 用于回到初始状态
        Button home = new Button("\u2302");
        home.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        home.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        home.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        home.styleProperty().bind(
                Bindings
                        .when(home.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        ));

        //数字按钮'3'
        Button num3 = new Button("3");
        num3.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num3.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num3.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num3.styleProperty().bind(
                Bindings
                        .when(num3.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //数字按钮'2'
        Button num2 = new Button("2");
        num2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num2.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num2.styleProperty().bind(
                Bindings
                        .when(num2.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //数字按钮'1'
        Button num1 = new Button("1");
        num1.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num1.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        num1.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num1.styleProperty().bind(
                Bindings
                        .when(num1.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //减法运算符'-'   用于减法运算
        Button sub = new Button("-");
        sub.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sub.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sub.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        sub.styleProperty().bind(
                Bindings
                        .when(sub.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #949494;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #2e2e2e;")
                        ));

        //平方运算符'x²'  用于计算一个数的平方
        Button xPower2 = new Button("x²");
        xPower2.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        xPower2.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        xPower2.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        xPower2.styleProperty().bind(
                Bindings
                        .when(xPower2.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        ));

        //平方根运算符 用于求解一个数的平方根
        Button sqrt = new Button("\u221A");
        sqrt.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sqrt.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sqrt.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        sqrt.styleProperty().bind(
                Bindings
                        .when(sqrt.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        ));

        //数字按钮'0'
        Button num0 = new Button("0");
        num0.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        num0.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        //num0.setStyle("-fx-line-height: 1.8;");
        num0.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        num0.styleProperty().bind(
                Bindings
                        .when(num0.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: gray;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: white;")
                        ));

        //数字按钮'.'  用于在小数的输入
        Button dot = new Button(".");
        dot.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        dot.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        dot.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        dot.styleProperty().bind(
                Bindings
                        .when(dot.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #949494;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #2e2e2e;")
                        ));

        //求余运算符'%'  用于求解一个数除以另外一个数的余数
        Button mod = new Button("%");
        mod.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        mod.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        mod.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        mod.styleProperty().bind(
                Bindings
                        .when(mod.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #949494;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #2e2e2e;")
                        ));

        //加法运算符 '+'  用于加法运算
        Button sum = new Button("+");
        sum.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sum.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sum.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        sum.styleProperty().bind(
                Bindings
                        .when(sum.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #949494;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #2e2e2e;")
                        ));

        //正弦函数运算符'sin'   用于求解一个数的正弦值
        Button sin = new Button("sin");
        sin.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sin.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sin.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        sin.styleProperty().bind(
                Bindings
                        .when(sin.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        )
        );


        //反正弦函数运算符'sinh' 用于求解一个值的反正弦
        Button sinh = new Button("sinh");
        sinh.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        sinh.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        sinh.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        sinh.styleProperty().bind(
                Bindings
                        .when(sinh.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        )
        );

        //运算符'=' 用于求一个式子的结果
        Button equal = new Button("=");
        equal.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        equal.prefWidthProperty().bind(mainPane.widthProperty().divide(3));
        equal.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        equal.styleProperty().bind(
                Bindings
                        .when(equal.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #f4a54d;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #b96501;")
                        ));

        Button pi = new Button("PI");
        pi.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        pi.prefWidthProperty().bind(mainPane.widthProperty().divide(4));
        pi.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        pi.styleProperty().bind(
                Bindings
                        .when(pi.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #f4a54d;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #b96501;")
                        ));


        //余弦运算符'cos'  用于求一个数的余弦值
        Button cos = new Button("cos");
        cos.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        cos.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        cos.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        cos.styleProperty().bind(
                Bindings
                        .when(cos.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        )
        );

        //反余弦运算符'cosh'  用于求解一个值的反余弦
        Button cosh = new Button("cosh");
        cosh.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        cosh.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        cosh.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        cosh.styleProperty().bind(
                Bindings
                        .when(cosh.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        )
        );

        //正切运算符'tan' 用于求解一个数的正切值
        Button tan = new Button("tan");
        tan.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        tan.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        tan.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        tan.styleProperty().bind(
                Bindings
                        .when(tan.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        )
        );

        //反正切运算符'tanh'   用于求解一个值的反正切值
        Button tanh = new Button("tanh");
        tanh.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        tanh.prefWidthProperty().bind(mainPane.widthProperty().divide(6));
        tanh.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        tanh.styleProperty().bind(
                Bindings
                        .when(tanh.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #4f7aa2;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #34516e;")
                        )
        );

        //水平框 hBox1  用于存放数字7，8，9  以及 除法运算符'／' 删除回退键 '<-' 重置键 正弦'sin' 反正弦'sinh'
        HBox hBox1 = new HBox(5);
        hBox1.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox1.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox1.getChildren().addAll(num7, num8, num9, div, backSpace, home, sin, sinh);

        //水平框 hBox2  用于存放数字4，5，6   以及乘法运算符  左右括号  余弦 反余弦
        HBox hBox2 = new HBox(5);
        hBox2.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox2.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox2.getChildren().addAll(num4, num5, num6, mul, b1, b2, cos, cosh);

        //水平框 hBox3  用于存放数字1，2，3  以及减法运算符 平方 平方根 正切 反正切
        HBox hBox3 = new HBox(5);
        hBox3.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox3.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox3.getChildren().addAll(num1, num2, num3, sub, xPower2, sqrt, tan, tanh);

        //水平框 hBox4   用于存放 点 数字0 % +  =
        HBox hBox4 = new HBox(5);
        hBox4.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        hBox4.prefWidthProperty().bind(primaryStage.widthProperty());
        hBox4.getChildren().addAll(num0, dot, mod, sum, pi, equal);

        //水平框 show 用于显示计算的过程和结果  由equal按钮来是实现响应
        VBox show = new VBox(5);
        show.prefHeightProperty().bind(primaryStage.heightProperty().divide(3));

        TextArea showResultProcess = new TextArea();
        // Label showResultProcess = new Label();
        // TextField showResultProcess=new TextField();
        //显示运算过程的文本框
        showResultProcess.setPrefColumnCount(2);
        showResultProcess.prefHeightProperty().bind(mainPane.heightProperty());

        show.prefWidthProperty().bind(primaryStage.widthProperty());
        show.getChildren().addAll(showResultProcess);
        //show.getChildren().addAll(showResultProcess);






        //各个按钮的响应事件
        num0.setOnMouseClicked(e -> {
            String x = "0";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "0";
                exp += x2;
                textField.setText(exp);
                res = false;

            }
        });

        num1.setOnMouseClicked(e -> {
            String x = "1";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "1";
                exp += x2;
                textField.setText(exp);
                res = false;

            }

        });
        num2.setOnMouseClicked(e -> {
            String x = "2";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "2";
                exp += x2;
                textField.setText(exp);
                res = false;

            }

        });
        num3.setOnMouseClicked(e -> {
            String x = "3";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "3";
                exp += x2;
                textField.setText(exp);
                res = false;

            }

        });
        num4.setOnMouseClicked(e -> {
            String x = "4";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "4";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num5.setOnMouseClicked(e -> {
            String x = "5";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "5";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num6.setOnMouseClicked(e -> {
            String x = "6";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "6";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num7.setOnMouseClicked(e -> {
            String x = "7";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);
                String x2 = "7";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num8.setOnMouseClicked(e -> {
            String x = "8";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "8";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        num9.setOnMouseClicked(e -> {
            String x = "9";
            exp += x;
            textField.setText(exp);
            if (res == true) {
                exp = "";
                textField.setText(exp);

                String x2 = "9";
                exp += x2;
                textField.setText(exp);
                res = false;
            }
        });

        dot.setOnMouseClicked(e -> {
            if (x2 == false) {
                String x = ".";
                exp += x;
                textField.setText(exp);
                res = false;
                x2 = true;
            }
        });

        mod.setOnMouseClicked(e -> {
            String x = "%";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        sin.setOnMouseClicked(e -> {

            exp += "S" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        sinh.setOnMouseClicked(e -> {
            exp += "s" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        cos.setOnMouseClicked(e -> {
            exp += "C" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        cosh.setOnMouseClicked(e -> {
            exp += "c" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        tan.setOnMouseClicked(e -> {
            exp += "T" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        tanh.setOnMouseClicked(e -> {
            exp += "t" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        mul.setOnMouseClicked(e -> {

            String x = "*";
            exp += x;
            textField.setText(exp);
            res = false;

            x2 = false;

        });

        div.setOnMouseClicked(e -> {
            String x = "/";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        sum.setOnMouseClicked(e -> {
            String x = "+";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        sub.setOnMouseClicked(e -> {
            String x = "-";
            exp += x;
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        equal.setOnMouseClicked(e -> {
            try {
                //String [] Expression=exam.divide(exp);
                //  history[indexof]=exp;
                //  indexof++;
              /*
    		   textField.setText(exam.solve(Expression));
    		   exp=exam.solve(Expression);
    		   */
                //error found here
                ss += exp;
                exp = exam.solve2(exp);
                textField.setText(exp);

                showResultProcess.setStyle("-fx-text-fill:red; -fx-font-size: 22;");
                //test.setStyle("-fx-text-fill:red; -fx-font-size: 22;");
                ss = ss + "=" + exp + "\n";
                // showResultProcess.setText(ss);
                showResultProcess.setText(ss);

                res = true;
                x2 = false;
            } catch (NullPointerException eed) {
            } catch (NumberFormatException eed) {
            }
        });


        home.setOnMouseClicked(e -> {
            exp = "";
            textField.setText(exp);
            x2 = false;
            res = false;
        });

        approx.setOnMouseClicked(e -> {
            try {
                //int X=Integer.parseInt(textField.toString());
                double result2 = Double.parseDouble(exp);
                double result = Math.round(result2);
                int YY = (int) result;
                String XX = Integer.toString(YY);
                exp = XX;
                textField.setText(exp);
                res = true;

                x2 = false;
            } catch (NumberFormatException t) {
            }


        });

        pi.setOnMouseClicked(e -> {

            exp = Double.toString(Math.PI);
            textField.setText(exp);
            res = false;
        });

        backSpace.setOnMouseClicked(e -> {
            try {
                int i = 1;
                exp = exp.substring(0, exp.length() - i);

                i++;
                textField.setText(exp);
                res = false;
                x2 = false;


            } catch (IndexOutOfBoundsException ees) {

            }
        });

        /**
         * here we do it 4-5^
         * 4-(5)^
         * @param e
         */
        xPower2.setOnMouseClicked(e -> {
            exp += "^";
            int yy = 0;
            int yy2 = 0;
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '^') {
                    yy = i;
                }
            }
            for (int i = yy; i >= 1; i--) {
                if ((exp.charAt(i) == '-' || exp.charAt(i) == '+' || exp.charAt(i) == '*' ||
                        exp.charAt(i) == '%' || exp.charAt(i) == '/') && i != 0) {
                    yy2 = i + 1;
                    break;
                }
            }
            String h = exp.substring(0, yy2);
            String u = exp.substring(yy2, yy);
            exp = "";
            exp = h + "(" + u + "^" + ")";
            textField.setText(exp);
            res = false;
            x2 = false;
        });

        b1.setOnMouseClicked(e -> {

            exp += "(";
            textField.setText(exp);
            res = false;
            x2 = false;

        });

        b2.setOnMouseClicked(e -> {

            exp += ")";
            textField.setText(exp);
            res = false;
            x2 = false;


        });

        imp.setOnMouseClicked(e ->
        {
            try {
                Double toBeTruncated = new Double(exp);
                Double truncatedDouble = new BigDecimal(toBeTruncated)
                        .setScale(2, BigDecimal.ROUND_HALF_UP)
                        .doubleValue();
                exp = Double.toString(truncatedDouble);
                textField.setText(exp);
            } catch (NullPointerException ee) {
                exp = "Erorr Expression";
                textField.setText(exp);
                exp = "";
            } catch (NumberFormatException ee) {
                exp = "Erorr Expression";
                textField.setText(exp);
                exp = "";

            }

        });

        sqrt.setOnMouseClicked(e ->
        {
            exp += "R" + "(";
            textField.setText(exp);
            res = false;
            x2 = false;
        });


        textField.setDisable(true);


        //显示过程框的三个编辑按钮的定义
        //save按钮用于把过程存为txt文件保存在磁盘上
        Button save = new Button("SAVE");
        save.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        save.prefWidthProperty().bind(mainPane.widthProperty().divide(3));
        save.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        save.styleProperty().bind(
                Bindings
                        .when(save.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #f4a54d;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #b96501;")
                        ));

        //copy按钮用于将过程框中选定的部分复制到剪切板上用于其他应用的粘贴
        Button copy = new Button("COPY");
        copy.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        copy.prefWidthProperty().bind(mainPane.widthProperty().divide(3));
        copy.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        copy.styleProperty().bind(
                Bindings
                        .when(copy.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #f4a54d;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #b96501;")
                        ));

        //clear按钮用于清除显示框中的内容
        Button clear = new Button("CLEAR");
        clear.prefHeightProperty().bind(mainPane.heightProperty().divide(5));
        clear.prefWidthProperty().bind(mainPane.widthProperty().divide(3));
        clear.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 12));
        clear.styleProperty().bind(
                Bindings
                        .when(clear.hoverProperty())
                        .then(
                                new SimpleStringProperty("-fx-color: #f4a54d;")
                        )
                        .otherwise(
                                new SimpleStringProperty("-fx-color: #b96501;")
                        ));
        //水平框 edit  用于存放三个编辑键 -- save copy clear
        HBox edit = new HBox(3);
        edit.prefHeightProperty().bind(primaryStage.heightProperty().divide(4));
        edit.prefWidthProperty().bind(primaryStage.widthProperty());
        edit.getChildren().addAll(save, copy, clear);

        //三个编辑键的响应事件的编写
        save.setOnMouseClicked(
                e ->
                {

                    File f = new File("/Users/my/Documents/result.txt"); //创建拖出的文件
                    OutputStreamWriter outputString = null;
                    try {
                        f.createNewFile();
                        outputString = new OutputStreamWriter(new FileOutputStream(f));
                        outputString.write(ss);
                    } catch (IOException x) {
                        x.printStackTrace();
                    } finally {
                        try {
                            outputString.close();
                        } catch (IOException x) {
                            x.printStackTrace();
                        }
                        exp = "saved succeed";
                        textField.setText(exp);
                    }
                });

        copy.setOnMouseClicked(e -> {
            exp = "copyed succeed";
            textField.setText(exp);
            String temp = showResultProcess.getSelectedText(); //拖动鼠标选取文本。
            StringSelection text = new StringSelection(temp);
            content.putString(temp);
            clipboard.setContent(content);
            res = false;
            x2 = false;
        });

        clear.setOnMouseClicked(e -> {
            exp = "cleared succeed";
            ss = "";
            textField.setText(exp);
            showResultProcess.setText(ss);
            res = false;
            x2 = false;
        });


        //主窗体的大小、布局
        mainPane.getChildren().addAll(textField, hb, hBox1, hBox2, hBox3, hBox4, show, edit);
        Scene scene = new Scene(mainPane, 500, 500);//410 500
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }


}
