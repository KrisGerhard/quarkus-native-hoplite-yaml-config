package org.acme

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class Config(val greetingText: String)
