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

public class Uzbektili extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {

            long chatIdd=update.getMessage().getChatId();

            if (update.getMessage().hasText()) {
                String messageText = update.getMessage().getText();

                // Language selection

                if (messageText.equals("Uzbek")) {

                    sendContactSharingMessage1(chatIdd);

                }





            }

            if (update.getMessage().hasContact()) {
                Contact contact1 = update.getMessage().getContact();
                String phoneNumber1 = contact1.getPhoneNumber();
                String firstName1 = contact1.getFirstName();
                String lastName1 = contact1.getLastName();

                // Process the received contact
                processContactt(chatIdd, phoneNumber1, firstName1, lastName1);
                sendLocationSharingMessage1(chatIdd);
            }

            if (update.getMessage().hasLocation()) {
                Location location1 = update.getMessage().getLocation();
                double latitude1 = location1.getLatitude();
                double longitude1 = location1.getLongitude();

                // Process the received location
                processLocationn(chatIdd, latitude1, longitude1);
                backHome(chatIdd);
            }

            // Handle received location

        }
    }

    private void backHome(long chatIdd){

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatIdd));


        // Create a ReplyKeyboardMarkup
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true); // Optional: resize the keyboard to fit the screen

        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow languageRow = new KeyboardRow();
        languageRow.add(new KeyboardButton("Back_Home"));
        keyboardRowList.add(languageRow);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        message.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }




    private void sendContactSharingMessage1(long chatIdd) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatIdd));
        message.setText("Iltimos siz bilan bog'lanish oson bo'lishi uchun nomeringizni ulashing!!!");
        ReplyKeyboardMarkup replyKeyboardMarkup1 = new ReplyKeyboardMarkup();
        replyKeyboardMarkup1.setResizeKeyboard(true); // Optional: resize the keyboard to fit the screen

        // Create rows for the keyboard buttons
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow contactRow = new KeyboardRow();
        KeyboardButton contactButton = new KeyboardButton("Nomer ulashish");
        contactButton.setRequestContact(true); // Enable contact sharing
        contactRow.add(contactButton);
        keyboardRowList.add(contactRow);

        replyKeyboardMarkup1.setKeyboard(keyboardRowList);

        // Set the reply keyboard markup in the message
        message.setReplyMarkup(replyKeyboardMarkup1);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendLocationSharingMessage1(long chatIdd) {

        // Create rows for the keyboard buttons

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatIdd));

        message.setText("Sizni turgan joyingizni aniqlashimiz oson bo'lishi uchun joylashuvingizni yuboring!!!");
        message.setParseMode(ParseMode.MARKDOWN);
        message.setChatId(String.valueOf(message.getChatId()));


        ReplyKeyboardMarkup replyKeyboardMarkup1 = new ReplyKeyboardMarkup();
        replyKeyboardMarkup1.setResizeKeyboard(true);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        keyboardButton1.setText("Joylashuvni yuborish\uD83D\uDCCD");
        keyboardRow1.add(new KeyboardButton("Back_Home"));
        keyboardButton1.setRequestLocation(true);
        keyboardRow1.add(keyboardButton1);
        keyboardRowList.add(keyboardRow1);
        replyKeyboardMarkup1.setKeyboard(keyboardRowList);
        message.setReplyMarkup(replyKeyboardMarkup1);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }



    }


    private void processContactt(long chatIdd, String phoneNumber, String firstName, String lastName) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatIdd));
        message.setText("Kontakt ulashildi:\n" + "Telefon nomer: " + phoneNumber + "\nIsm: " + firstName);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void processLocationn(long chatIdd, double latitude, double longitude) {
        // Perform actions with the received location information
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatIdd));
        message.setText("Manzil yuborganingiz uchun rahmat siz bilan bog'lanib, siz turgan joyga taksi yuboramiz!!. Foydalanganiz uchun rahmat");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

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

