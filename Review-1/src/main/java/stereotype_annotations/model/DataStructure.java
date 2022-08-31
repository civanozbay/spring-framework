package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
@Component
public class DataStructure {
    @NonNull
    ExtraHours extraHours;
    public void getTotalHours(){
        System.out.println("Total hours : "+(35 +extraHours.getHours()));
    }
}
