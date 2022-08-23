package com;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ExampleBot extends TelegramLongPollingBot {

    private String BOT_USERNAME = "weatherlivepybot";
    private String BOT_TOKEN = "761235389:AAFlBgDe8a9yZFU7wpwtjytJHVqY63PGLXQ";

    private String START_MESSAGE = "Привет!\n" +
            "Это мой первый бот написанный на языке JAVA. \n" +
            "Пока что доступны только некоторые команда: \n" +
            "/help - список всех команд \n" +
            "/calc - калькулятор \n" +
            "/start - запуск бота \n" +
            "/stop - остановка бота \n\n" +
            "Скоро доработаю этого бота!";

    private String HELP_MESSAGE = "Список всех доступных команд: \n" +
            "/help - список всех команд \n" +
            "/calc - калькулятор \n" +
            "/start - запуск бота \n" +
            "/stop - остановка бота";

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                if (message.hasText()) {
                    String text = message.getText();
                    if (text.equals("/start")) {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setChatId(message.getChatId().toString());
                        sendMessage.setText(START_MESSAGE);
                        execute(sendMessage);
                    } else if (text.contains("Ты кто")) {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setChatId(message.getChatId().toString());
                        sendMessage.setText("Я тот кто тебя захуярит)");
                        execute(sendMessage);
                    } else if (text.contains("/calc")) {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setChatId(message.getChatId().toString());
                        sendMessage.setText("https://okcalc.com/ru/");
                        execute(sendMessage);
                    } else if (text.contains("/help")) {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setChatId(message.getChatId().toString());
                        sendMessage.setText(HELP_MESSAGE);
                        execute(sendMessage);
                    } else if (text.contains("/stop")) {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setChatId(message.getChatId().toString());
                        sendMessage.setText("Bot was stopped!");
                        execute(sendMessage);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
