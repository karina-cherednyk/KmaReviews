package com.moop.kmareviews.entities;

public final class Views {
    public interface Brief {};

    public interface Full extends Brief {};
    public interface FullCourse extends Full{};
    public interface FullTeacher extends Full{};
}
