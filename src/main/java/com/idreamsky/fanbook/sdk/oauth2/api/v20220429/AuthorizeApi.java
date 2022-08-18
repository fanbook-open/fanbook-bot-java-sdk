package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;

import java.util.HashMap;
import java.util.Map;

/**
 * 打开授权页面（**For Web**）
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorizeApi extends FanbookRestfulApi<String> {

    @Builder.Default
    @SerializedName("response_type")
    private String responseType = "code";

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("allow")
    private String allow;

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("state")
    private String state;


    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "open/oauth2/authorize";
    }

    /**
     * Fanbook bot api的接口的请求方式
     *
     * @return HttpMethodType
     */
    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.GET;
    }

    /**
     * 获取响应实体类的class；
     * PS：注意不要使用带泛型的实体类T
     *
     * @return T
     */
    @Override
    public Class<String> getResponseClass() {
        return String.class;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == responseType || responseType.isEmpty()) {
            throw new BotArgumentException("responseType must not be null");
        }
        if (null == clientId || clientId.isEmpty()) {
            throw new BotArgumentException("clientId must not be null");
        }
    }

    /**
     * 根据数据传递格式，构造request body
     *
     * @return request body的字符串形式
     */
    @Override
    public String buildBody(ClientProfile clientProfile) {
        return null;
    }

    @Override
    protected Map<String, String> buildHeader(ClientProfile clientProfile) {
        super.addHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
        return headers;
    }

    @Override
    protected Map<String, String> buildUriVariables(ClientProfile clientProfile) {
        Map<String, String> vars = new HashMap<>(8);
        vars.put("response_type", responseType);
        if (null == clientProfile || clientId.isEmpty()) {
            clientId = clientProfile.getClientKey();
        }
        vars.put("client_id", clientId);
        vars.put("allow", allow);
        vars.put("status_code", statusCode);
        vars.put("state", state);
        return vars;
    }
}
