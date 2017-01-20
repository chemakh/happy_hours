package com.ch.happyhours.service.Exception;


import com.ch.happyhours.service.utils.MessageFactory;
import com.ch.happyhours.service.web.error.FieldErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HappyHoursException extends Exception {
    private Logger logger = LoggerFactory.getLogger(HappyHoursException.class);

    public static final String WITH_ID = "id";
    public static final String WITH_EMAIL = "email";
    public static final String WITH_REF = "Reference";
    public static final String WITH_GLN = "Gln";

    private HappyHoursServiceError motif;
    private String code;
    private FieldErrorDTO fieldError;

    public FieldErrorDTO getFieldError() {
        return fieldError;
    }

    public void setFieldError(FieldErrorDTO fieldError) {
        this.fieldError = fieldError;
    }


    public HappyHoursException(Throwable cause) {
        super(cause);
        this.motif = HappyHoursServiceError.ERR_HappyHours;

        logger.error("HappyHoursException is Thrown");
        logger.error(this.getMessage());
    }

    private HappyHoursException(String txt, HappyHoursServiceError cause, String code) {
        super(txt);
        this.motif = cause;
        this.code = code;

        logger.error("HappyHoursException is Thrown");
        logger.error(this.getMessage());
    }

    @Override
    public String getMessage() {
        return super.getMessage();

    }

    public HappyHoursServiceError getMotif() {
        if (motif == null) {
            motif = HappyHoursServiceError.ERR_HappyHours;
        }
        return motif;
    }

    public void setMotif(HappyHoursServiceError motif) {
        this.motif = motif;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static HappyHoursException actionNotPermittedErrorBuilder(String message) {
        return new HappyHoursException(message, HappyHoursServiceError.ACTION_NOT_PERMITTED, null);
    }

    public static HappyHoursException actionUnauthorizedErrorBuilder(String message) {
        return new HappyHoursException(message, HappyHoursServiceError.ACTION_UNAUTHORIZED, null);
    }

    public static HappyHoursException unprocessableEntityExceptionBuilder(String message) {
        return new HappyHoursException(message, HappyHoursServiceError.UNPROCESSABLE_ENTITY, null);
    }

    public static HappyHoursException validationErrorBuilder(FieldErrorDTO fieldError) {

        String message = MessageFactory.getMessage("happy-hours.exception.validation_error." + fieldError.getMessage(), new String[]{fieldError.getObjectName(), fieldError.getField()});
        HappyHoursException ex = new HappyHoursException(message, HappyHoursServiceError.VALIDATION_ERROR, null);
        ex.setFieldError(fieldError);
        return ex;
    }

    public static HappyHoursException invalidCodeExceptionBuilder(String key) {

        return new HappyHoursException(MessageFactory.getMessage("happy-hours.exception.invalid_code", new String[]{key}), HappyHoursServiceError.INVALID_CODE, null);
    }

    public static HappyHoursException identifierAlreadyInUseExceptionBuilderBuilder(String identifier, String value) {

        return new HappyHoursException(MessageFactory.getMessage("happy-hours.exception.identifier_already_in_use", new String[]{identifier, value}), HappyHoursServiceError.IDENTIFIER_ALREADY_IN_USE, null);

    }

    public static HappyHoursException resourceNotFoundExceptionBuilder(Class object, String reference, String idType) {

        return new HappyHoursException(MessageFactory.getMessage("happy-hours.exception.resource_not_found", new String[]{object.getSimpleName(), idType, reference}), HappyHoursServiceError.RESOURCE_NOT_FOUND, null);

    }

    public static HappyHoursException resourceNotFoundExceptionBuilder(Class object, String reference) {

        return new HappyHoursException(MessageFactory.getMessage("happy-hours.exception.resource_not_found", new String[]{object.getSimpleName(), WITH_REF, reference}), HappyHoursServiceError.RESOURCE_NOT_FOUND, null);

    }

    public static HappyHoursException resourceNotFoundExceptionBuilder(String object, String reference, String idType) {

        return new HappyHoursException(MessageFactory.getMessage("happy-hours.exception.resource_not_found", new String[]{object, idType, reference}), HappyHoursServiceError.RESOURCE_NOT_FOUND, null);

    }

    public static HappyHoursException resourceNotFoundExceptionBuilder(String object, String reference) {

        return new HappyHoursException(MessageFactory.getMessage("happy-hours.exception.resource_not_found", new String[]{object, WITH_REF, reference}), HappyHoursServiceError.RESOURCE_NOT_FOUND, null);

    }
}
