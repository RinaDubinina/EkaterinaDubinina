package hw_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SpellerDto {
private int code;
private int pos;
    private int col;
    private int len;
    private String word;
    private List<String> s;
   }


