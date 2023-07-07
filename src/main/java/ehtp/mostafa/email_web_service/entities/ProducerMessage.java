package ehtp.mostafa.email_web_service.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor

public class ProducerMessage implements Serializable {
    String header ;
    String Body ;
}
