# Telegram API
Telegram API implementation based on Feign http client.

## Include dependency
Add the following snippet to any project's pom that depends on **telegram-api** project:
```xml
<repositories>
    <repository>
        <id>telegram-api</id>
        <url>https://raw.github.com/xxlabaza/telegram-api/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```
Then, include dependency to your project:
```xml
<dependencies>
    ...
    <dependency>
        <groupId>ru.xxlabaza</groupId>
        <artifactId>telegram-api</artifactId>
        <version>1.0.0</version>
    </dependency>
    ...
</dependencies>
```

## Authorizing your bot
Each bot is given a unique authentication token [when it is created](https://core.telegram.org/bots#botfather). The token looks something like 123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11.

## Basic usage
* Getting info about bot:
```java
TelegramService SERVICE = new TelegramService("<bot-api-token>");
User user = SERVICE.getMe().call();

Assert.assertNotNull(user.getId());
Assert.assertNotNull(user.getFirstName());
```

* Sending message:
```java
Message message = SERVICE.sendMessage()
        .chat("<chat-id>")
        .text("Hello world!")
        .call();
```

* Read user's input:
```java
List<Update> updates = SERVICE.getUpdates()
        .offset(10)
        .limit(50)
        .call();
```

For more information - read [Telegram API](https://core.telegram.org/api) and library's **JavaDoc**.