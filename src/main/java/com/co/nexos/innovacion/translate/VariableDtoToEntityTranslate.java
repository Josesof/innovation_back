package com.co.nexos.innovacion.translate;

import org.springframework.stereotype.Component;

import com.co.nexos.innovacion.dto.VariableDTO;
import com.co.nexos.innovacion.entity.Variable;
import com.co.nexos.innovacion.exception.MsjException;
import com.co.nexos.innovacion.pattern.Translator;

/** @author lfernandez - QVision sas */
@Component
public class VariableDtoToEntityTranslate implements Translator<VariableDTO, Variable> {

  @Override
  public Variable translate(VariableDTO input) throws MsjException {
    return Variable.builder()
        .build();
  }
}
