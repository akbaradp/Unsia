package com.example.puasa.Utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class MessageModel {

    private String msg;
    private boolean status;
    private Object data;
}
