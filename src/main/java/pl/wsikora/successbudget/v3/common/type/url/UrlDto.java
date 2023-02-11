package pl.wsikora.successbudget.v3.common.type.url;

import lombok.Value;

import java.io.Serializable;


@Value
public class UrlDto implements Serializable {

    String editUrl;
    String deleteUrl;

}
