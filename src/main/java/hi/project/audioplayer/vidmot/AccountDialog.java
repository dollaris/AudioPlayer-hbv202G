    package hi.project.audioplayer.vidmot;

    import hi.project.audioplayer.vinnsla.Account;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Node;
    import javafx.scene.control.*;

    import java.io.IOException;

    public class AccountDialog extends Dialog<Account> {
        private Account player;
        @FXML
        private TextField name;
        @FXML
        private ButtonType signInBtn;
        @FXML
        private ButtonType cancelBtn;


        //Constructor
        public AccountDialog() {
            super();
        }

        /**
         *  Constructor
         * @param player
         */
        public AccountDialog(Account player) {
            super();
            this.setTitle("Subscribe");
            this.player = player;
            initialize();
        }

        /**
         * Initialize the dialog by setting the dialog pane, property binding, result converter, and checking if the OK button is pressed.
         *
         */
        @FXML
        private void initialize() {
            setDialogPane(readDialog());
            setPropertyBinding();
            setResultConverter();
            isOKBtn();

            Node cancelBtn2 = getDialogPane().lookupButton(cancelBtn);
            cancelBtn2.setStyle("-fx-font-size: 14px;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-background-color: #1db954;\n" +
                    "    -fx-background-radius: 5;\n" +
                    "    -fx-background-radius: 50em;\n" +
                    "    -fx-padding: 8 16;");

        }


        /**
         * This function sets the result converter for the dialog.
         */
        private void setResultConverter() {
            setResultConverter( b -> {
                if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                    return player;
                } else {
                    return null;
                }
            });
        }

        /**
         * This function sets up a property binding for the name property.
         */
        private void setPropertyBinding() {
            name.textProperty().bindBidirectional(player.nameProperty());
        }

        /**
         * A description of the entire Java function.
         *
         * @return         description of return value
         */
        private DialogPane readDialog() {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-view.fxml"));
            try {
                fxmlLoader.setController(this);
                return fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        private void isOKBtn() {
            Node isOK = getDialogPane().lookupButton(signInBtn);

            isOK.disableProperty().bind(name.textProperty().isEmpty());
            isOK.setStyle("-fx-font-size: 14px;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-background-color: #1db954;\n" +
                    "    -fx-background-radius: 5;\n" +
                    "    -fx-background-radius: 50em;\n" +
                    "    -fx-padding: 8 16;");
        }
    }
