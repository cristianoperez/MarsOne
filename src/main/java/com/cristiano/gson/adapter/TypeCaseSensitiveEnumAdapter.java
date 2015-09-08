package com.cristiano.gson.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.cristiano.exception.InvalidCommandException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TypeCaseSensitiveEnumAdapter implements TypeAdapterFactory {

	@SuppressWarnings("unchecked")
	@Override
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
		Class<T> rawType = (Class<T>) type.getRawType();
		if (!rawType.isEnum()) {
			return null;
		}

		final Map<String, T> lowercaseToConstant = new HashMap<String, T>();
		for (T constant : rawType.getEnumConstants()) {
			lowercaseToConstant.put(toLowercase(constant), constant);
		}

		return new TypeAdapter<T>() {
			public void write(JsonWriter out, T value) throws IOException {
				if (value == null) {
					out.nullValue();
				} else {
					out.value(toLowercase(value));
				}
			}

			@Override
			public T read(JsonReader reader) throws IOException {
				if (reader.peek() == JsonToken.NULL) {
					reader.nextNull();
					return null;
				} else {
					String commandStr = reader.nextString().toLowerCase();
					T t = lowercaseToConstant.get(commandStr);
					if(t == null){
						throw new InvalidCommandException("Comando '"+ commandStr +"' é invalido");
					}
					return t;
				}
			}

		};

	}

	private String toLowercase(Object o) {
		return o.toString().toLowerCase(Locale.US);
	}
}