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
        Workout(R.string.stairs_mastery, R.drawable.stairs, R.array.stairs_mastery_tips, WorkoutCategory.CARDIO),

        Workout(R.string.bench_press, R.drawable.bench_press, R.array.bench_press_tips, WorkoutCategory.CHEST),
        Workout(R.string.incline_bench_press, R.drawable.incline_bench_press, R.array.incline_bench_press_tips, WorkoutCategory.CHEST),
        Workout(R.string.pectoral_flys, R.drawable.pectoral_flys, R.array.pectoral_flys_tips, WorkoutCategory.CHEST),

        Workout(R.string.pull_ups, R.drawable.pull_ups, R.array.pull_ups_tips, WorkoutCategory.BACK),
        Workout(R.string.lat_pulldown, R.drawable.lat_pulldown, R.array.lat_pulldown_tips, WorkoutCategory.BACK),

        Workout(R.string.squat, R.drawable.squat, R.array.squat_tips, WorkoutCategory.LEGS),
        Workout(R.string.lunges, R.drawable.lunges, R.array.lunges_tips, WorkoutCategory.LEGS),

        Workout(R.string.shoulder_press, R.drawable.shoulder_press, R.array.shoulder_press_tips, WorkoutCategory.SHOULDERS),
        Workout(R.string.lateral_raises, R.drawable.lateral_raises, R.array.lateral_raises_tips, WorkoutCategory.SHOULDERS),

        Workout(R.string.crunch, R.drawable.crunch, R.array.crunch_tips, WorkoutCategory.CORE),
        Workout(R.string.leg_raise, R.drawable.leg_raise, R.array.leg_raise_tips, WorkoutCategory.CORE),
        Workout(R.string.flutter_kicks, R.drawable.flutter_kicks, R.array.flutter_kicks_tips, WorkoutCategory.CORE),
        Workout(R.string.bicycle_abs, R.drawable.bicycle_abs, R.array.bicycle_abs_tips, WorkoutCategory.CORE),
        Workout(R.string.plank, R.drawable.plank, R.array.plank_tips, WorkoutCategory.CORE),
        Workout(R.string.russian_twists, R.drawable.russian_twists, R.array.russian_twists_tips, WorkoutCategory.CORE),
        Workout(R.string.bicep_curl, R.drawable.bicep_curl, R.array.bicep_curl_tips, WorkoutCategory.ARMS),
        Workout(R.string.stationary_biking, R.drawable.stationary_bike, R.array.stationary_biking_tips, WorkoutCategory.CARDIO),
        Workout(R.string.push_ups, R.drawable.push_ups, R.array.push_ups_tips, WorkoutCategory.ARMS)
    )
}

enum class WorkoutCategory(val displayName: String) {
    ALL("All"),
    CARDIO("Cardio"),
    CHEST("Chest"),
    BACK("Back"),
    LEGS("Legs"),
    SHOULDERS("Shoulders"),
    ARMS("Arms"),
    CORE("Core"),
}