package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        NKtaxi NKtaxi =new NKtaxi();
        try {
            TelegramBotsApi botsApi=new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(NKtaxi);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        Uzbektili uzbektili=new Uzbektili();

        try {
            TelegramBotsApi botsApi=new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(uzbektili);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        Englishtil englishtil=new Englishtil();

        try {
            TelegramBotsApi botsApi=new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(englishtil);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }
}
