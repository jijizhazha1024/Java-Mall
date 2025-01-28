package utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String msg;
    private Object data;
    private Long code;

    public static Result ok(){
        return new Result(null, null, null);
    }
    public static Result ok(Object data){
        return new Result(null, data, null);
    }
    public static Result ok(List<?> data, Long code){
        return new Result(null, data, code);
    }
    public static Result fail(String msg){
        return new Result(msg, null, null);
    }
}
