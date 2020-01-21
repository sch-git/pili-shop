package com.sch.commonbasic.VO;

import com.sch.commonbasic.enums.ResultEnum;
import lombok.Data;

/**
 * @Description: 统一返回结果
 * @Author: chenghao.su
 * @Date: 2020/1/21 11:03
 */
@Data
public class Result {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回信息
     */
    private String message;

    public Result() {

    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    /**
     * 成功-无数据
     *
     * @return Result
     */
    public static Result success() {
        return new Result(ResultEnum.SUCCESS);
    }

    /**
     * 成功-携带数据
     *
     * @param data 数据
     * @return Result
     */
    public static Result success(Object data) {
        Result result = new Result(ResultEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败-无数据
     *
     * @return
     */
    public static Result failure() {
        Result result = new Result(ResultEnum.FAILURE);
        return result;
    }

}
