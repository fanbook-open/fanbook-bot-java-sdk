package com.idreamsky.fanbook.sdk.bot.model.v20230216;

import com.idreamsky.fanbook.sdk.bot.model.v20220429.CirclePost;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: peng.gan
 */
@Data
public class PostList implements Serializable {

    public List<CirclePost> records;

}
