package com.triple.web.params;

import com.triple.web.type.ActionType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class ReveiwWriteEventParams {
    private String type;
    private ActionType action;
    private String reveiwId;
    private String content;
    private List<String> attachedPhotoIds;
    private String userId;
    private String placeId;
}
