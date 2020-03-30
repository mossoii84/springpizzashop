package com.example.springpizzashop.websocketchat;

import lombok.Data;
import java.awt.*;

@Data
public class ChatMessage {
        private Type type;
        private String content;
        private String sender;
        private String from;    //будет содержать имя адресата
        private String message;

        private String username;
        private String body;


        // это для статуса клиента JOIN-защел,CHAT- в чате,LEAVE-вышел
        public enum Type {
                JOIN,
                CHAT,
                LEAVE
        }

}
