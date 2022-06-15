package com.idreamsky.fanbook.sdk;

import com.google.gson.Gson;
import com.idreamsky.fanbook.sdk.bot.constant.v20220429.ChannelTypeEnum;
import com.idreamsky.fanbook.sdk.bot.method.v20220429.*;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.*;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import com.idreamsky.fanbook.sdk.support.UpdateUtil;
import com.idreamsky.fanbook.sdk.support.constant.UpdateTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BotMethodTest {

    private ClientProfile clientProfile;
    private IFanbookBotClient fanbookClient;

    @Before
    public void init() {
        clientProfile = ClientProfile.getDefaultProfile();
        clientProfile.setBotToken("f2da539e8bb6db83073eec155809e449adfdaee4a3d012750c6aa3b8beb6d1d48d64ff6092879c88536af3e53249d61f");
        clientProfile.setClientKey("356994553305239552");
        clientProfile.setClientSecret("9UxLpq6EKj6vpwpT6kJrafyhOJW4L6Wd");
        clientProfile.setBotId(356997871750348800L);
        fanbookClient = new DefaultFanbookBotClient(clientProfile);
    }

    @Test
    public void TestGetMeMethod() {
        GetMeMethod getMeMethod = new GetMeMethod();
        User botResponse = fanbookClient.getBotResponse(getMeMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void TestSendMessageMethod() {
        SendMessageMethod sendMessageMethod = new SendMessageMethod();
        sendMessageMethod.setChatId(357042844399042561L);
        sendMessageMethod.setText("hello world");
        sendMessageMethod.setReplyToMessageId(360703245468827648L);
        Message botResponse = fanbookClient.getBotResponse(sendMessageMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void TestSendPhotoMethod() {
        SendPhotoMethod sendPhotoMethod = new SendPhotoMethod();
        sendPhotoMethod.setChatId(357042844399042561L);
        sendPhotoMethod.setPhoto(new HashMap());
        sendPhotoMethod.getPhoto().put("Url", "https://fanbook-cartoon-1251001060.cos.ap-shanghai.myqcloud.com/hssm/1651116474236/飞书20220427-100154.jpg");
        sendPhotoMethod.setReplyToMessageId(360703245468827648L);
        Message botResponse = fanbookClient.getBotResponse(sendPhotoMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void TestKickChatMember() {
        KickChatMemberMethod kickChatMemberMethod = new KickChatMemberMethod();
        kickChatMemberMethod.setUserId(1L);
        kickChatMemberMethod.setChatId(357042844399042561L);
        Boolean botResponse = fanbookClient.getBotResponse(kickChatMemberMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetBotsMethod() {
        GetBotsMethod getBotsMethod = new GetBotsMethod();
        getBotsMethod.setOwnerId(173022860380475392L);
        getBotsMethod.setAuthorization("c912b6f823d925c25d14e8855c04ef5b4b2cd3b71c78476fdd6af1f67f50b170a8d82f93620d5ab113c6f3cb7e42c1453dfba0007834b0c0dc7a40053f9be4024a48192747823da6c7cd73f60adf16fb7ca613ff9976e20beec09812abc782c2");
        ArrayList<Bot> botResponse = fanbookClient.getBotResponse(getBotsMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }


    @Test
    public void testSetBotPrivacyModeMethod() {
        SetBotPrivacyModeMethod setBotPrivacyModeMethod = new SetBotPrivacyModeMethod();
        setBotPrivacyModeMethod.setBotId(358193373657432064L);
        setBotPrivacyModeMethod.setOwnerId(173022860380475392L);
        setBotPrivacyModeMethod.setAuthorization("c912b6f823d925c25d14e8855c04ef5b4b2cd3b71c78476fdd6af1f67f50b170a8d82f93620d5ab113c6f3cb7e42c1453dfba0007834b0c0dc7a40053f9be4024a48192747823da6c7cd73f60adf16fb7ca613ff9976e20beec09812abc782c2");
        setBotPrivacyModeMethod.setEnable(true);
        Serializable botResponse = fanbookClient.getBotResponse(setBotPrivacyModeMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testSetBotCommandsMethod() {
        SetBotCommandsMethod setBotCommandsMethod = new SetBotCommandsMethod();
        setBotCommandsMethod.setBotId(358193373657432064L);
        setBotCommandsMethod.setOwnerId(173022860380475392L);
        setBotCommandsMethod.setAuthorization("c912b6f823d925c25d14e8855c04ef5b4b2cd3b71c78476fdd6af1f67f50b170a8d82f93620d5ab113c6f3cb7e42c145e5b23ad503263afe192948ef5a8efb2865675c56a3e4b445e6a4f86387842315a080cb2a7528754f82f66efcd8161c44");
        List<BotCommand> botCommands = new ArrayList<>();
        BotCommand botCommand = new BotCommand();
        botCommand.setCommand("旋转");
        botCommand.setDescription("非常棒的一个指令2");
        botCommand.setVisibleLevel(0);
        botCommands.add(botCommand);
        setBotCommandsMethod.setCommands(botCommands);
        Serializable botResponse = fanbookClient.getBotResponse(setBotCommandsMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetMyCommandsMethod() {
        GetMyCommandsMethod getMyCommandsMethod = new GetMyCommandsMethod();
        ArrayList<BotCommand> botResponse = fanbookClient.getBotResponse(getMyCommandsMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testSetCreditMethod() {
        SetCreditMethod setCreditMethod = new SetCreditMethod();
        setCreditMethod.setUserId("173022860380475392");
        setCreditMethod.setChatId(357042844231282688L);
//        setCreditMethod.setGuildId("357042844231282688");
        setCreditMethod.setCardId(String.valueOf(System.currentTimeMillis()));
        GuildCredit guildCredit = new GuildCredit();
        guildCredit.setTitle(CreditTitle.builder()
                .img("https://fanbook-cartoon-1251001060.cos.ap-shanghai.myqcloud.com/hssm/1522779573807353856.jpg")
                .build());
        guildCredit.setAuthority(CreditAuthority.builder()
                .icon("https://xiaodongwu-forum-1251001060.file.myqcloud.com/fanbook/gamelogo/logomini.png")
                .name("小动物之星2")
                .build());
        List<List<CreditSlot>> creditSlots = new ArrayList<>();
        guildCredit.setSlots(creditSlots);
        {
            List<CreditSlot> list = new ArrayList<>();
            list.add(CreditSlot.builder().label("角色名称").value("ToTheMoon").build());
            list.add(CreditSlot.builder().label("角色等级").value("99").build());
            creditSlots.add(list);
        }
        {
            List<CreditSlot> list = new ArrayList<>();
            list.add(CreditSlot.builder().label("当前称号").value("天梯第一ADC").build());
            list.add(CreditSlot.builder().label("当前赛季场次").value("99").build());
            creditSlots.add(list);
        }
        {
            List<CreditSlot> list = new ArrayList<>();
            list.add(CreditSlot.builder().value("常用动物家族").img("https://xiaodongwu-forum-1251001060.file.myqcloud.com/fanbook/animal/icon_head_fox.png").build());
            list.add(CreditSlot.builder().value("擅长枪械").img("https://xiaodongwu-forum-1251001060.file.myqcloud.com/fanbook/weapon/melee_katana.png").build());
            list.add(CreditSlot.builder().value("常用坐骑").img("https://xiaodongwu-forum-1251001060.file.myqcloud.com/fanbook/vehicle/icon_personal_vehicle_hamsterball.png").build());
            list.add(CreditSlot.builder().value("积分排行").img("https://fanbook-cartoon-1251001060.cos.ap-shanghai.myqcloud.com/hssm/1522779573807353856.jpg").build());
            creditSlots.add(list);
        }
        setCreditMethod.setGuildCredit(guildCredit);
        Boolean botResponse = fanbookClient.getBotResponse(setCreditMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }


    @Test
    public void testDeleteCreditMethod() {
        DeleteCreditMethod deleteCreditMethod = new DeleteCreditMethod();
        deleteCreditMethod.setCardId("1651894375412");
        deleteCreditMethod.setUserId("173022860380475392");
        deleteCreditMethod.setChatId(357042844231282688L);
        Boolean botResponse = fanbookClient.getBotResponse(deleteCreditMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetPrivateChatMethod() {
        GetPrivateChatMethod getPrivateChatMethod = new GetPrivateChatMethod();
        getPrivateChatMethod.setUserId(173022860380475392L);
        Chat botResponse = fanbookClient.getBotResponse(getPrivateChatMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testSearchGuildMember() {
        SearchGuildMemberMethod searchGuildMemberMethod = new SearchGuildMemberMethod();
        searchGuildMemberMethod.setGuildId(357042844231282688L);
        searchGuildMemberMethod.setQuery("173022860380475392");
        Serializable botResponse = fanbookClient.getBotResponse(searchGuildMemberMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGuildMembersMethod() {
        GuildMembersMethod guildMembersMethod = new GuildMembersMethod();
        guildMembersMethod.setGuildId("357042844231282688");
        guildMembersMethod.setChannelId("357042844399042561");
        guildMembersMethod.setUserId("173022860380475392");
        List<GuildMembersMethod.Range> ranges = new ArrayList<>();
        ranges.add(GuildMembersMethod.Range.builder().start(0).end(10).build());
        guildMembersMethod.setRanges(ranges);
        Serializable botResponse = fanbookClient.getBotResponse(guildMembersMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }


    @Test
    public void testGetGuildMembersMethod() {
        GetGuildMembersMethod guildMembersMethod = new GetGuildMembersMethod();
        guildMembersMethod.setGuildId(357042844231282688L);
        ArrayList<ChatMember> botResponse = fanbookClient.getBotResponse(guildMembersMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetRoleMembersMethod() {
        GetRoleMembersMethod getRoleMembersMethod = new GetRoleMembersMethod();
        getRoleMembersMethod.setGuildId(357042844231282688L);
        getRoleMembersMethod.setRoleId(359938031379030016L);
        ArrayList<ChatMember> botResponse = fanbookClient.getBotResponse(getRoleMembersMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetGuildRolesMethod() {
        GetGuildRolesMethod getGuildRolesMethod = new GetGuildRolesMethod();
        getGuildRolesMethod.setGuildId(357042844231282688L);
        ArrayList<GuildRole> botResponse = fanbookClient.getBotResponse(getGuildRolesMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testSetMemberRolesMethod() {
        SetMemberRolesMethod setMemberRolesMethod = new SetMemberRolesMethod();
        setMemberRolesMethod.setGuildId(357042844231282688L);
        setMemberRolesMethod.setUserId(138519745866498048L);
        setMemberRolesMethod.setRoles(Arrays.asList(363598927506702336L));
        Serializable botResponse = fanbookClient.getBotResponse(setMemberRolesMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testPinChatMessageMethod() {
        PinChatMessageMethod pinChatMessageMethod = new PinChatMessageMethod();
        pinChatMessageMethod.setChatId(357042844399042561L);
        pinChatMessageMethod.setMessageId(363558160520192000L);
        pinChatMessageMethod.setChannelId(357042844399042561L);
        Boolean botResponse = fanbookClient.getBotResponse(pinChatMessageMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testUnpinChatMessageMethod() {
        UnpinChatMessageMethod unpinChatMessageMethod = new UnpinChatMessageMethod();
        unpinChatMessageMethod.setChatId(357042844399042561L);
        unpinChatMessageMethod.setMessageId(363525141713395712L);
        Boolean botResponse = fanbookClient.getBotResponse(unpinChatMessageMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetChatMemberMethod() {
        GetChatMemberMethod getChatMemberMethod = new GetChatMemberMethod();
        getChatMemberMethod.setGuildId(357042844231282688L);
        getChatMemberMethod.setUserId(138519745866498048L);
        Serializable botResponse = fanbookClient.getBotResponse(getChatMemberMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testEditMessageTextMethod() {
        EditMessageTextMethod editMessageTextMethod = new EditMessageTextMethod();
        editMessageTextMethod.setText(String.format("现在是北京时间：%s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"))));
        editMessageTextMethod.setMessageId(363558160520192000L);
        editMessageTextMethod.setChatId(357042844399042561L);
        Boolean botResponse = fanbookClient.getBotResponse(editMessageTextMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testEditMessageTextMethodLoop() throws InterruptedException {
        {
            EditMessageTextMethod editMessageTextMethod = new EditMessageTextMethod();
            editMessageTextMethod.setText(String.format("接下来开始准备倒计时了"));
            editMessageTextMethod.setMessageId(363558160520192000L);
            editMessageTextMethod.setChatId(357042844399042561L);
            Boolean botResponse = fanbookClient.getBotResponse(editMessageTextMethod);

        }
        for (int i = 100; i >= 0; i--) {
            EditMessageTextMethod editMessageTextMethod = new EditMessageTextMethod();
            editMessageTextMethod.setText(String.format("开始倒计时：%s", i));
            editMessageTextMethod.setMessageId(363558160520192000L);
            editMessageTextMethod.setChatId(357042844399042561L);
            Boolean botResponse = fanbookClient.getBotResponse(editMessageTextMethod);
            TimeUnit.SECONDS.sleep(1);
        }
        {
            EditMessageTextMethod editMessageTextMethod = new EditMessageTextMethod();
            editMessageTextMethod.setText(String.format("倒计时结束，无事发生"));
            editMessageTextMethod.setMessageId(363558160520192000L);
            editMessageTextMethod.setChatId(357042844399042561L);
            Boolean botResponse = fanbookClient.getBotResponse(editMessageTextMethod);

        }
    }

    @Test
    public void testEditMessageReplyMarkupMethod() {
        EditMessageReplyMarkupMethod editMessageReplyMarkupMethod = new EditMessageReplyMarkupMethod();
        editMessageReplyMarkupMethod.setMessageId(363558160520192000L);
        editMessageReplyMarkupMethod.setUserId("173022860380475392");
        editMessageReplyMarkupMethod.setData("editMessageReplyMarkupMethod");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> arrayLists = new ArrayList<>();
        List<InlineKeyboardButton> boards = new ArrayList<>();
        arrayLists.add(boards);
        boards.add(InlineKeyboardButton
                .builder()
                .callbackData("你好")
                .text("一个按钮")
                .build());
        inlineKeyboardMarkup.setKeyboard(arrayLists);
        editMessageReplyMarkupMethod.setReplyMarkup(inlineKeyboardMarkup);
        Message botResponse = fanbookClient.getBotResponse(editMessageReplyMarkupMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }


    @Test
    public void testDeleteMessageMethod() {
        DeleteMessageMethod deleteMessageMethod = new DeleteMessageMethod();
        deleteMessageMethod.setMessageId(363143124622508032L);
        deleteMessageMethod.setChatId(357042844399042561L);
        Boolean botResponse = fanbookClient.getBotResponse(deleteMessageMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }


    @Test
    public void testGetMessageMethod() {
        GetMessageMethod getMessageMethod = new GetMessageMethod();
        getMessageMethod.setChatId(357042844399042561L);
        getMessageMethod.setMessageId(363143124622508032L);
        Message botResponse = fanbookClient.getBotResponse(getMessageMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }


    @Test
    public void testSendNoticationMethod() {
        SendNoticationMethod sendNoticationMethod = new SendNoticationMethod();
        sendNoticationMethod.setChannelType("1");
        sendNoticationMethod.setToUserId("138519745866498048L");
        sendNoticationMethod.setContent("今天吃饭了吗");
        sendNoticationMethod.setNonce(String.valueOf(System.currentTimeMillis()));
        sendNoticationMethod.setExtra("test extra");
        Serializable botResponse = fanbookClient.getBotResponse(sendNoticationMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testCirclePostDetailMethod() {
        CirclePostDetailMethod circlePostDetailMethod = new CirclePostDetailMethod();
        circlePostDetailMethod.setPostId("357403575611039744");
        Serializable botResponse = fanbookClient.getBotResponse(circlePostDetailMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testCirclePostReactionListBotMethod() {
        CirclePostReactionListBotMethod circlePostReactionListBotMethod = new CirclePostReactionListBotMethod();
        circlePostReactionListBotMethod.setPostId("358508027923410944");
        CirclePostReaction botResponse = fanbookClient.getBotResponse(circlePostReactionListBotMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testCirclePostCommentListMethod() {
        // https://fanbook.mobi/channels/196434572819300352/340454446712500224/340454789399707648
        CirclePostCommentListMethod circlePostCommentListMethod = new CirclePostCommentListMethod();
        circlePostCommentListMethod.setPostId("340454789399707648");
        circlePostCommentListMethod.setChannelId("340454446712500224");
        Serializable botResponse = fanbookClient.getBotResponse(circlePostCommentListMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetUpdatesMethod() {
        GetUpdatesMethod getUpdatesMethod = new GetUpdatesMethod();
        ArrayList<Update> botResponse = fanbookClient.getBotResponse(getUpdatesMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
        Map<UpdateTypeEnum, List<Update>> updateTypeEnumListMap = UpdateUtil.messageGroup(botResponse);
        log.info("UpdateGroup:{}", new Gson().toJson(updateTypeEnumListMap));
    }


    @Test
    public void testGetGuildInfomationMethod() {
        GetGuildInfomationMethod getGuildInfomationMethod = new GetGuildInfomationMethod();
        getGuildInfomationMethod.setGuildId("357042844231282688");
        getGuildInfomationMethod.setUserId("1");
        Serializable botResponse = fanbookClient.getBotResponse(getGuildInfomationMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));

    }

    @Test
    public void testCreateChannelMethod() {
        CreateChannelMethod createChannelMethod = new CreateChannelMethod();
        createChannelMethod.setUserId("356997871750348800");
        createChannelMethod.setGuildId("357042844231282688");
        createChannelMethod.setName("私聊频道");
        createChannelMethod.setType(ChannelTypeEnum.TextChannel.getId());
        createChannelMethod.setLink("http://www.baidu.com");
        createChannelMethod.setParentId("357042844390653952");
        // ""
        createChannelMethod.setPermissionOverwrites(Arrays.asList(PermissionOverwrite.builder().id("173022860380475392").actionType("user").allows(1024).deny(0).build(),
                PermissionOverwrite.builder().id("233558858419671040").actionType("user").allows(1024).deny(0).build(),
                PermissionOverwrite.builder().id("357042844281614336").actionType("role").allows(0).deny(1024).build()));
        Serializable botResponse = fanbookClient.getBotResponse(createChannelMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testListChannelMethod() {
        ListChannelMethod listChannelMethod = new ListChannelMethod();
        listChannelMethod.setUserId("356997871750348800");
        listChannelMethod.setGuildId("357042844231282688");
        Serializable botResponse = fanbookClient.getBotResponse(listChannelMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testCreateRoleMethod(){
        CreateRoleMethod createRoleMethod = new CreateRoleMethod();
        createRoleMethod.setGuildId("357042844231282688");
        createRoleMethod.setName("小蜜蜂");
        createRoleMethod.setColor(1);
        createRoleMethod.setPosition(0L);
        GuildRole botResponse = fanbookClient.getBotResponse(createRoleMethod);
        log.info("botResponse:{}", new Gson().toJson(botResponse));
    }
}