package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Poll implements Serializable {
    private static final String ID_FIELD = "id";
    private static final String QUESTION_FIELD = "question";
    private static final String OPTIONS_FIELD = "options";
    private static final String TOTALVOTERCOUNT_FIELD = "total_voter_count";
    private static final String ISCLOSED_FIELD = "is_closed";
    private static final String ISANONYMOUS_FIELD = "is_anonymous";
    private static final String TYPE_FIELD = "type";
    private static final String ALLOWSMULTIPLEANSWERS_FIELD = "allows_multiple_answers";
    private static final String CORRECTOPTIONID_FIELD = "correct_option_id";
    private static final String OPENPERIOD_FIELD = "open_period";
    private static final String CLOSEDATE_FIELD = "close_date";
    private static final String EXPLANATION_FIELD = "explanation";
    private static final String EXPLANATIONENTITIES_FIELD = "explanation_entities";

    @SerializedName(ID_FIELD)
    private String id; ///< Unique poll identifier
    @SerializedName(QUESTION_FIELD)
    private String question; ///< Poll question, 1-255 characters
    @SerializedName(OPTIONS_FIELD)
    private List<PollOption> options; ///< List of poll options
    @SerializedName(TOTALVOTERCOUNT_FIELD)
    private Integer totalVoterCount; ///< Total number of users that voted in the poll
    @SerializedName(ISCLOSED_FIELD)
    private Boolean isClosed; ///< True, if the poll is closed
    @SerializedName(ISANONYMOUS_FIELD)
    private Boolean isAnonymous; ///< True, if the poll is closed
    @SerializedName(TYPE_FIELD)
    private String type; ///< Poll type, currently can be “regular” or “quiz”
    @SerializedName(ALLOWSMULTIPLEANSWERS_FIELD)
    private Boolean allowMultipleAnswers; ///< True, if the poll allows multiple answers

    @SerializedName(CORRECTOPTIONID_FIELD)
    private Integer correctOptionId; ///< True, if the poll allows multiple answers
    @SerializedName(OPENPERIOD_FIELD)
    private Integer openPeriod; ///< Optional. Amount of time in seconds the poll will be active after creation
    @SerializedName(CLOSEDATE_FIELD)
    private Integer closeDate; ///< Optional. Point in time (Unix timestamp) when the poll will be automatically closed
    @SerializedName(EXPLANATION_FIELD)
    private String explanation; ///< Optional. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
    @SerializedName(EXPLANATIONENTITIES_FIELD)
    private List<MessageEntity> explanationEntities; ///< Optional. Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
}