package org.telegram.telegrambots.meta.api.methods.groupadministration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodBoolean;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;
import org.telegram.telegrambots.meta.util.Validations;

/**
 * @author Ruben Bermudez
 * @version 4.5
 * Use this method to set a custom title for an administrator in a supergroup promoted by the bot.
 * Returns True on success.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetChatAdministratorCustomTitle extends BotApiMethodBoolean {
    public static final String PATH = "setChatAdministratorCustomTitle";

    private static final String CHATID_FIELD = "chat_id";
    private static final String USERID_FIELD = "user_id";
    private static final String CUSTOMTITLE_FIELD = "custom_title";

    @JsonProperty(CHATID_FIELD)
    @NonNull
    private String chatId; ///< Unique identifier for the target chat or username of the target channel (in the format @channelusername)
    @JsonProperty(USERID_FIELD)
    @NonNull
    private Long userId; ///< Unique identifier of the target user
    @JsonProperty(CUSTOMTITLE_FIELD)
    @NonNull
    private String customTitle; ///< New custom title for the administrator; 0-16 characters, emoji are not allowed

    @Tolerate
    public void setChatId(@NonNull Long chatId) {
        this.chatId = chatId.toString();
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        Validations.requiredChatId(chatId, this);
        Validations.requiredUserId(userId, this);
    }

    public static abstract class SetChatAdministratorCustomTitleBuilder<C extends SetChatAdministratorCustomTitle, B extends SetChatAdministratorCustomTitleBuilder<C, B>> extends BotApiMethodBooleanBuilder<C, B> {
        @Tolerate
        public SetChatAdministratorCustomTitleBuilder<C, B> chatId(@NonNull Long chatId) {
            this.chatId = chatId.toString();
            return this;
        }
    }
}
