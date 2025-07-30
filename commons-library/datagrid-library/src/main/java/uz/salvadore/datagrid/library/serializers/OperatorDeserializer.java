package uz.salvadore.datagrid.library.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import uz.salvadore.datagrid.library.enums.Operator;

import java.io.IOException;

public class OperatorDeserializer extends StdDeserializer<Operator> {

  public OperatorDeserializer() {
    super(Operator.class);
  }

  @Override
  public Operator deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
    return Operator.of(jsonParser.getValueAsString());
  }
}
