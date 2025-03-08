package com.example.a30days

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.a30days.data.Workout
import com.example.a30days.data.WorkoutCategory
import com.example.a30days.data.WorkoutRepository
import com.example.compose._30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysTheme {
                Surface()
                {
                    WorkoutList(WorkoutRepository.workouts)
                }
            }
        }
    }
}


@Composable
fun WorkoutList(workouts: List<Workout>) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(WorkoutCategory.ALL)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())
    ) {
        WorkoutSearchBar(
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it }
        )

        WorkoutCategoryChips(
            selectedCategory = selectedCategory,
            onCategorySelect = { selectedCategory = it}
        )

        val filteredWorkouts = workouts.filter {
            (selectedCategory == WorkoutCategory.ALL|| it.category == selectedCategory) &&
                    (searchQuery.isBlank() || stringResource(it.nameRes).contains(searchQuery, ignoreCase = true))
        }
        Spacer(modifier = Modifier
            .height(8.dp))

        LazyColumn {
            items(filteredWorkouts, key = { it.nameRes }) { workout ->
                WorkoutCard(workout = workout)
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun WorkoutSearchBarPreview() {
    _30DaysTheme {
        Surface()
        {
            WorkoutList(WorkoutRepository.workouts)
        }
    }
}

@Composable
fun WorkoutSearchBar(searchQuery: String, onSearchQueryChange: (String) -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            label = { Text("Search Workouts")},
            singleLine = true,
            shape = MaterialTheme.shapes.medium,
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search")},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant, // Background when focused
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant, // Background when not focused
                focusedIndicatorColor = MaterialTheme.colorScheme.primary, // Border when focused
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurfaceVariant, // Border when not focused
                cursorColor = MaterialTheme.colorScheme.primary, // Cursor color
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}


@Composable
fun WorkoutCategoryChips(selectedCategory: WorkoutCategory, onCategorySelect: (WorkoutCategory) -> Unit) {
    Card (
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ){
        LazyRow (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(WorkoutCategory.entries) { category ->
                FilterChip(
                    selected = category == selectedCategory,
                    onClick = { onCategorySelect(category) },
                    label = { Text(category.displayName) },
                    shape = MaterialTheme.shapes.medium,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        labelColor = MaterialTheme.colorScheme.onSurface
                    )

                )
            }
        }
    }


}

@Composable
fun WorkoutCard(
    workout: Workout,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    // Change color when card is clicked
    val cardColor = if (expanded) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.surfaceVariant

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable (
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ){ expanded = !expanded }
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),

            ){
                AsyncImage(
                    model = workout.imageRes,
                    contentDescription = stringResource(workout.nameRes),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }
            
            Text(
                text = stringResource(workout.nameRes),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
            if (expanded) {
                Column {
                    LocalContext.current.resources.getStringArray(workout.tipsArrayRes).forEach { tip ->
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 4.dp)
                        ){
                            Icon(
                                painter = painterResource(R.drawable.baseline_check_24),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier
                                    .size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text =tip,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    }
                }
            }
        }
    }
}