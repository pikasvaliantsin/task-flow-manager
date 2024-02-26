package by.it.academy.feingClient;

import by.it.academy.dto.responses.PersonalNumberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "personal-number-client", url="${services.external.personal-number-api.url}")
public interface PersonalNumberApiClient {

    @GetMapping
    PersonalNumberDto getPersonalNumber();
}