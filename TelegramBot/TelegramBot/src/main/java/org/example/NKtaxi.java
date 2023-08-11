package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class NKtaxi extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            long chatId = update.getMessage().getChatId();
            long chatIdd=update.getMessage().getChatId();

            if (update.getMessage().hasText()) {
                String messageText = update.getMessage().getText();

                // Language selection

                if (messageText.equals("/start")) {

                    SendMessage sendMessage = new SendMessage();

                    String userName = update.getMessage().getFrom().getFirstName();
                    sendMessage.setText("Assalomu alaykum  " + userName + ". Men NK Taxi \uD83D\uDE95 xizmati botiman!\n" +
                            " \"Hi  " + userName + "! I am NK Taxi \uD83D\uDE95 service bot!");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);

                    sendLanguageSelectionMessage(chatId);

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }

                // Name sharing
                 else if (messageText.equals("Back_Home")) {
                    sendLanguageSelectionMessage(chatId);
                }


            }

            /*if (update.getMessage().hasContact()) {
                Contact contact = update.getMessage().getContact();
                String phoneNumber = contact.getPhoneNumber();
                String firstName = contact.getFirstName();
                String lastName = contact.getLastName();
                // Process the received contact
                processContact(chatId, phoneNumber, firstName, lastName);
               // sendLocationSharingMessage(chatId);


            }

            // Handle received location
            if (update.getMessage().hasLocation()) {
                Location location = update.getMessage().getLocation();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                // Process the received location
                processLocation(chatId, latitude, longitude);

            }*/
        }
    }


    private void sendLanguageSelectionMessage(long chatId) {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Assalomu alaykum  " +  ". Men NK Taxi \uD83D\uDE95 xizmati botiman!\n"  +
                "Hi  ! I am NK Taxi \uD83D\uDE95 service bot!\n"+"\n Iltimos til tanlang!!!");


        // Create a ReplyKeyboardMarkup
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true); // Optional: resize the keyboard to fit the screen

        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow languageRow = new KeyboardRow();
        languageRow.add(new KeyboardButton("English"));
        languageRow.add(new KeyboardButton("Uzbek"));
        keyboardRowList.add(languageRow);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        message.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }



    }




   /* private void sendContactSharingMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Please share your contact:");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true); // Optional: resize the keyboard to fit the screen

        // Create rows for the keyboard buttons
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow contactRow = new KeyboardRow();
        KeyboardButton contactButton = new KeyboardButton("Share Contact");
        contactButton.setRequestContact(true); // Enable contact sharing
        contactRow.add(contactButton);
        keyboardRowList.add(contactRow);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        // Set the reply keyboard markup in the message
        message.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




    private void sendLocationSharingMessage(long chatId) {




        // Create rows for the keyboard buttons

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));

        message.setText("Submit your location so we can easily locate you!!!");
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(message.getChatId()));


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        keyboardButton1.setText("Share location\uD83D\uDCCD");
        keyboardRow1.add(new KeyboardButton("Back_Home"));
        keyboardButton1.setRequestLocation(true);
        keyboardRow1.add(keyboardButton1);
        keyboardRowList.add(keyboardRow1);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        message.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void processContact(long chatId, String phoneNumber, String firstName, String lastName) {
        // Perform actions with the received contact information
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Contact shared:\n" + "Phone Number: " + phoneNumber + "\nFirst Name: " + firstName);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void processLocation(long chatId, double latitude, double longitude) {
        // Perform actions with the received location information
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Thank you for sending the address, we will contact you and send a taxi to your location!!. Thank you for using" );

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
*/







    @Override
    public String getBotUsername() {
        // Return your bot's username
        return "@Nktaxi_bot";
    }

    @Override
    public String getBotToken() {
        // Return your bot's token received from BotFather
        return "6035274270:AAFMocn4JFDdIohsoy_-BscnnnqAnjPjHn8";
    }


}
