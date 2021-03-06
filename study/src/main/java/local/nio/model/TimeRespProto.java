// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TimeResp.proto

package local.nio.model;

public final class TimeRespProto {
    private TimeRespProto() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface TimeRespOrBuilder extends
            // @@protoc_insertion_point(interface_extends:protobuf.TimeResp)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string time = 1;</code>
         */
        String getTime();

        /**
         * <code>string time = 1;</code>
         */
        com.google.protobuf.ByteString
        getTimeBytes();
    }

    /**
     * Protobuf type {@code protobuf.TimeResp}
     */
    public static final class TimeResp extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:protobuf.TimeResp)
            TimeRespOrBuilder {
        // Use TimeResp.newBuilder() to construct.
        private TimeResp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private TimeResp() {
            time_ = "";
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        private TimeResp(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!input.skipField(tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            String s = input.readStringRequireUtf8();

                            time_ = s;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return TimeRespProto.internal_static_protobuf_TimeResp_descriptor;
        }

        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return TimeRespProto.internal_static_protobuf_TimeResp_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            TimeRespProto.TimeResp.class, TimeRespProto.TimeResp.Builder.class);
        }

        public static final int TIME_FIELD_NUMBER = 1;
        private volatile Object time_;

        /**
         * <code>string time = 1;</code>
         */
        public String getTime() {
            Object ref = time_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                time_ = s;
                return s;
            }
        }

        /**
         * <code>string time = 1;</code>
         */
        public com.google.protobuf.ByteString
        getTimeBytes() {
            Object ref = time_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                time_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (!getTimeBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, time_);
            }
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getTimeBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, time_);
            }
            memoizedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TimeRespProto.TimeResp)) {
                return super.equals(obj);
            }
            TimeRespProto.TimeResp other = (TimeRespProto.TimeResp) obj;

            boolean result = true;
            result = result && getTime()
                    .equals(other.getTime());
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + TIME_FIELD_NUMBER;
            hash = (53 * hash) + getTime().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static TimeRespProto.TimeResp parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TimeRespProto.TimeResp parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TimeRespProto.TimeResp parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TimeRespProto.TimeResp parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TimeRespProto.TimeResp parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TimeRespProto.TimeResp parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TimeRespProto.TimeResp parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static TimeRespProto.TimeResp parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TimeRespProto.TimeResp parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static TimeRespProto.TimeResp parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TimeRespProto.TimeResp parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static TimeRespProto.TimeResp parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TimeRespProto.TimeResp prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code protobuf.TimeResp}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:protobuf.TimeResp)
                TimeRespProto.TimeRespOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return TimeRespProto.internal_static_protobuf_TimeResp_descriptor;
            }

            protected FieldAccessorTable
            internalGetFieldAccessorTable() {
                return TimeRespProto.internal_static_protobuf_TimeResp_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                TimeRespProto.TimeResp.class, TimeRespProto.TimeResp.Builder.class);
            }

            // Construct using local.nio.model.TimeRespProto.TimeResp.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            public Builder clear() {
                super.clear();
                time_ = "";

                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return TimeRespProto.internal_static_protobuf_TimeResp_descriptor;
            }

            public TimeRespProto.TimeResp getDefaultInstanceForType() {
                return TimeRespProto.TimeResp.getDefaultInstance();
            }

            public TimeRespProto.TimeResp build() {
                TimeRespProto.TimeResp result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public TimeRespProto.TimeResp buildPartial() {
                TimeRespProto.TimeResp result = new TimeRespProto.TimeResp(this);
                result.time_ = time_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof TimeRespProto.TimeResp) {
                    return mergeFrom((TimeRespProto.TimeResp) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(TimeRespProto.TimeResp other) {
                if (other == TimeRespProto.TimeResp.getDefaultInstance()) return this;
                if (!other.getTime().isEmpty()) {
                    time_ = other.time_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                TimeRespProto.TimeResp parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (TimeRespProto.TimeResp) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private Object time_ = "";

            /**
             * <code>string time = 1;</code>
             */
            public String getTime() {
                Object ref = time_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    time_ = s;
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>string time = 1;</code>
             */
            public com.google.protobuf.ByteString
            getTimeBytes() {
                Object ref = time_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    time_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string time = 1;</code>
             */
            public Builder setTime(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                time_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string time = 1;</code>
             */
            public Builder clearTime() {

                time_ = getDefaultInstance().getTime();
                onChanged();
                return this;
            }

            /**
             * <code>string time = 1;</code>
             */
            public Builder setTimeBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                time_ = value;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return this;
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return this;
            }


            // @@protoc_insertion_point(builder_scope:protobuf.TimeResp)
        }

        // @@protoc_insertion_point(class_scope:protobuf.TimeResp)
        private static final TimeRespProto.TimeResp DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new TimeRespProto.TimeResp();
        }

        public static TimeRespProto.TimeResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        private static final com.google.protobuf.Parser<TimeResp>
                PARSER = new com.google.protobuf.AbstractParser<TimeResp>() {
            public TimeResp parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TimeResp(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TimeResp> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<TimeResp> getParserForType() {
            return PARSER;
        }

        public TimeRespProto.TimeResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_protobuf_TimeResp_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_protobuf_TimeResp_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n\016TimeResp.proto\022\010protobuf\"\030\n\010TimeResp\022\014" +
                        "\n\004time\030\001 \001(\tB \n\017local.nio.modelB\rTimeRes" +
                        "pProtob\006proto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        }, assigner);
        internal_static_protobuf_TimeResp_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_protobuf_TimeResp_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_protobuf_TimeResp_descriptor,
                new String[]{"Time",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
