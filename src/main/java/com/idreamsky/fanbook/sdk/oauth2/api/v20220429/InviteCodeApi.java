package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.InviteCodeResponse;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 根据邀请码查询持有邀请码对应的用户
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InviteCodeApi extends FanbookRestfulApi<InviteCodeResponse> {

    @SerializedName("c")
    private String c;


    @Override
    protected String getEndpoint() {
        return "api/invite/H5Page";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.GET;
    }

    @Override
    public Class<InviteCodeResponse> getResponseClass() {
        return InviteCodeResponse.class;
    }
    /**
     * 根据数据传递格式，构造request body
     *
     * @param clientProfile 客户端环境
     * @return 字符串格式的http request body
     */
    @Override
    protected String buildBody(ClientProfile clientProfile) {
        return null;
    }


    /**
     * 自定义构建URL变量
     *
     * @param clientProfile 客户端环境
     * @return k-v形式的URL变量集合
     */
    @Override
    protected Map<String, String> buildUriVariables(ClientProfile clientProfile) {
        this.addUriVariables("c", c);
        return super.uriVariables;
    }

    @Override
    public void validate() throws BotArgumentException {
        if (null == c || c.isEmpty()) {
            throw new BotArgumentException("c must not be empty");
        }
    }
}
