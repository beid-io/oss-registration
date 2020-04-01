package generated.protobuf.form;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Base64;

@Slf4j
class FormTest {

    @Test
    void testBuild() throws Exception {
        val form = Form.SigninForm.newBuilder()
                .setUsername("peerapat a")
                .setPassword("P@ssw0rd")
                .build();

        log.info("Message {}", form.toByteString().toStringUtf8());
        log.info("Message size {}, {}", form.toByteString().size(), form.toByteArray());
        log.info("Base 64 Message {}", Base64.getEncoder().encodeToString(form.toByteArray()));

        val bytes = form.toByteArray();
        val bean = Form.SigninForm.parseFrom(bytes);
        log.info("B {}", bean);

        assert bean != form : "instance should be different";
        assert bean.equals(form) : "instance should equivalent";
    }

}
