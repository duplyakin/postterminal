package entities;

import com.example.kanzeparovrr.postterminalcardapplicationmir.hl.storage.HLEntity;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class Entity implements HLEntity {

    private String HlId = "123";

    @Getter @Setter
    private String value;

    @Override
    public String getHlId() {
        return HlId;
    }

    @Override
    public void setHlId(String id) {
        HlId = id;
    }



}
