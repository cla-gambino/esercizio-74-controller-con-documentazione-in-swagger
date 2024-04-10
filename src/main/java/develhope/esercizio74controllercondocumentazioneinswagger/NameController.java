package develhope.esercizio74controllercondocumentazioneinswagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class NameController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return the name", content =
                    {
                            @Content(mediaType = "application/string")
                    })
    })

    @Operation(summary = "This method prints the name")
    @GetMapping(path = "/getName")
    public String name(@Parameter(description = "The user request param") @RequestParam(value = "nome", required = true) String nome) {
        return nome;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return the reverse name", content =
                    {
                            @Content(mediaType = "application/string")
                    })
    })


    @Operation(summary = "This method prints the reverse name")
    @PostMapping(path = "/getReverseName")
    public String reverseName(@Parameter(description = "The user reverse name param") @RequestParam(value = "nome", required = true) String nome) {
        return new StringBuilder(nome).reverse().toString();
    }
}

// http://localhost:8080/swagger-ui/index.html#/