package com.example.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30days.R

data class Workout(
    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int,
    val tipsArrayRes: Int,
    val category: WorkoutCategory
)

object WorkoutRepository {
    val workouts = listOf(
        Workout(R.string.treadmill, R.drawable.running, R.array.treadmill_tips, WorkoutCategory.CARDIO),
        Workout(R.string.bench_press, R.drawable.bench_press, R.array.bench_press_tips, WorkoutCategory.CHEST),
        Workout(R.string.squat, R.drawable.squat, R.array.squat_tips, WorkoutCategory.LEGS),
        Workout(R.string.stationary_biking, R.drawable.stationary_bike, R.array.stationary_biking_tips, WorkoutCategory.CARDIO),
    )
}

enum class WorkoutCategory(val displayName: String) {
    ALL("All"),
    CARDIO("Cardio"),
    CHEST("Chest"),
    LEGS("Legs"),
    FLEXIBILITY("Flexibility"),
    STRENGTH("Strength"),
    ENDURANCE("Endurance")
}