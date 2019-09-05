package com.hrt.cloud.common.web.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

    // @ResponseBody 添加@ResponseBody 返回Json
//    @ExceptionHandler(value = {MyAccessDeniedException.class})
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public BaseResponse accessDeniedException(MyAccessDeniedException ex) {
//        log.error("accessDenied exception:{}", ex.getMessage());
//        return BaseResponse.error(BRStatus.PERMISSION_NO_EXIST);
//    }
//
//    @ExceptionHandler(value = {NestedServletException.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public BaseResponse nestedServletException(NestedServletException ex) {
//        log.error("nestedServletException:{}", ex.getMessage());
//        return BaseResponse.error(BRStatus.exception);
//    }
//
//    @ExceptionHandler(value = {FeignException.class})
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public BaseResponse feignException(FeignException ex) {
//        log.error("feignException:{}", ex.getMessage());
//        return BaseResponse.error(BRStatus.PERMISSION_NO_EXIST);
//    }

//    @ExceptionHandler(value = {Exception.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public BaseResponse exception() {
//        return BaseResponse.error();
//    }
//
//    @ExceptionHandler(value = {Throwable.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public BaseResponse throwable() {
//        return BaseResponse.error();
//    }

}