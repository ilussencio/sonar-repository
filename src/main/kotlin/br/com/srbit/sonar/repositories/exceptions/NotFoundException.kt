package br.com.srbit.sonar.repositories.exceptions

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
data class NotFoundException(override val message : String?): RuntimeException(message) {
    @ExceptionHandler(DataAccessException::class)
    fun handlerDataException(ex: DataAccessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity(
            ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            ), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails>{
        val erros: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.stream().forEach{
                erro: ObjectError ->
            val fildName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage
            erros[fildName] = messageError
        }
        return ResponseEntity(
            ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = erros
            ), HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(IllegalAccessException::class)
    fun handlerIllegalAccessException(ex: IllegalAccessException): ResponseEntity<ExceptionDetails>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ExceptionDetails(
                    title = "Bad Request! Consult the documentation",
                    timestamp = LocalDateTime.now(),
                    status = HttpStatus.BAD_REQUEST.value(),
                    exception = ex.javaClass.toString(),
                    details = mutableMapOf(ex.cause.toString() to ex.message)
                )
            )
    }

    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(ex: NotFoundException): ResponseEntity<ExceptionDetails>{

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ExceptionDetails(
                    title = "No content found! Consult the documentation",
                    timestamp = LocalDateTime.now(),
                    status = HttpStatus.BAD_REQUEST.value(),
                    exception = ex.javaClass.toString(),
                    details = mutableMapOf(ex.cause.toString() to ex.message)
                )
            )
    }


}