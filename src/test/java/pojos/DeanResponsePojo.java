package pojos;


import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class DeanResponsePojo {
    private DeanObjectPojo object;
    private String message;
    private String httpStatus;


}
