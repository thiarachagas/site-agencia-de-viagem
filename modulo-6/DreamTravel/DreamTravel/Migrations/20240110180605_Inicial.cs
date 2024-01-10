using System;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace DreamTravel.Migrations
{
    public partial class Inicial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterDatabase()
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "companhia_aerea",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    nome = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_companhia_aerea", x => x.id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "destino",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    nome = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    descricao = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    localizacao = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    preco_medio = table.Column<double>(type: "double", nullable: false),
                    imagem = table.Column<byte[]>(type: "longblob", nullable: false),
                    internacional = table.Column<bool>(type: "tinyint(1)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_destino", x => x.id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "promocao",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    nome = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    data_inicio = table.Column<DateTime>(type: "datetime(6)", nullable: false),
                    data_termino = table.Column<DateTime>(type: "datetime(6)", nullable: false),
                    desconto = table.Column<double>(type: "double", nullable: false),
                    fk_destino_id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_promocao", x => x.id);
                    table.ForeignKey(
                        name: "FK_promocao_destino_fk_destino_id",
                        column: x => x.fk_destino_id,
                        principalTable: "destino",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "passagem",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    origem = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    data_partida = table.Column<DateTime>(type: "datetime(6)", nullable: false),
                    fk_destino_id = table.Column<int>(type: "int", nullable: false),
                    fk_companhia_aerea_id = table.Column<int>(type: "int", nullable: false),
                    fk_promocao_id = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_passagem", x => x.id);
                    table.ForeignKey(
                        name: "FK_passagem_companhia_aerea_fk_companhia_aerea_id",
                        column: x => x.fk_companhia_aerea_id,
                        principalTable: "companhia_aerea",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_passagem_destino_fk_destino_id",
                        column: x => x.fk_destino_id,
                        principalTable: "destino",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_passagem_promocao_fk_promocao_id",
                        column: x => x.fk_promocao_id,
                        principalTable: "promocao",
                        principalColumn: "id");
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateIndex(
                name: "IX_passagem_fk_companhia_aerea_id",
                table: "passagem",
                column: "fk_companhia_aerea_id");

            migrationBuilder.CreateIndex(
                name: "IX_passagem_fk_destino_id",
                table: "passagem",
                column: "fk_destino_id");

            migrationBuilder.CreateIndex(
                name: "IX_passagem_fk_promocao_id",
                table: "passagem",
                column: "fk_promocao_id");

            migrationBuilder.CreateIndex(
                name: "IX_promocao_fk_destino_id",
                table: "promocao",
                column: "fk_destino_id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "passagem");

            migrationBuilder.DropTable(
                name: "companhia_aerea");

            migrationBuilder.DropTable(
                name: "promocao");

            migrationBuilder.DropTable(
                name: "destino");
        }
    }
}
