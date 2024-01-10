using DreamTravel.Data;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

string AllowCorsPolicyName = "_AllowCors";

builder.Services.AddCors(policyBuilder => policyBuilder
    .AddPolicy(AllowCorsPolicyName, policy => policy
        .WithOrigins("*")
        .AllowAnyHeader()
        .AllowAnyMethod()
    )
);

builder.Services.AddDbContext<DataContext>(options =>
    {
        //options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection"));
        var connectionString = builder.Configuration.GetConnectionString("MySqlConnection");
        options.UseMySql(connectionString, ServerVersion.AutoDetect(connectionString));
    }
);

var app = builder.Build();

app.UseCors(AllowCorsPolicyName);

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();

app.MapControllers();

app.Run();
