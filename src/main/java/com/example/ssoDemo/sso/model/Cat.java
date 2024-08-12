package com.example.ssoDemo.sso.model;

import lombok.Data;

@Data
public class Cat {
    Status status;
    String _id;
    String user;
    String text;
    int __v;
    String source;
    String updatedAt;
    String type;
    String createdAt;
    String deleted;
    String used;

    @Data
    static class Status{
        boolean verified;
        int sentCount;
    }
}

//{
//        "status": {
//        "verified": true,
//        "sentCount": 1
//        },
//        "_id": "58e008780aac31001185ed05",
//        "user": "58e007480aac31001185ecef",
//        "text": "Owning a cat can reduce the risk of stroke and heart attack by a third.",
//        "__v": 0,
//        "source": "user",
//        "updatedAt": "2020-08-23T20:20:01.611Z",
//        "type": "cat",
//        "createdAt": "2018-03-29T20:20:03.844Z",
//        "deleted": false,
//        "used": false
//        }
